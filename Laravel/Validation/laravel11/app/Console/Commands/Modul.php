<?php

namespace App\Console\Commands;

use Illuminate\Console\Command;
use Illuminate\Filesystem\Filesystem;

class Modul extends Command
{
    protected const DEFAULT_EXTENTION = 'txt';
    protected Filesystem $filesystem;

    public function __construct(Filesystem $filesystem)
    {
        parent::__construct();
        $this->filesystem = $filesystem;
    }

    /**
     * @var string
     */
    protected $signature = 'modul {file} {teks} {--e|extension=} {--t|title=} {--A|append} {--php} {--test}';

    /**
     * @var string
     */
    protected $description = 'Membuat modul belajar laravel Validation';

    public function handle()
    {
        $file = $this->argument('file');
        $extention = $this->option('extension') ?? self::DEFAULT_EXTENTION;
        $title = $this->option('title') ?? $this->extractFileName($file);
        $teks = $this->argument('teks');
        $append = $this->option('append');
        $isPhp = $this->option('php');
        $isTest = $this->option('test');
        $path = config('ujun.modul.path', base_path() . DIRECTORY_SEPARATOR);

        $content = $this->makeContent($title, $teks);

        if ($isTest) {
            $extention = 'php';
            $content = $this->makeTestContent($file, $content);
        } else if ($isPhp) {
            $extention = 'php';
            $content = "<?php\n\n$content";
        }

        $this->ensureDirectoryExists($path . $this->extractFileFolder($file));
        $this->writeContent($path, $file, $extention, $content, $append);
        return \Symfony\Component\Console\Command\Command::SUCCESS;
    }

    private function makeContent(string $title, string $teks): string
    {
        $lines = mb_split("\r\n|\n", $teks) ?: [];
        array_unshift($lines, "/** $title");
        $lines = array_filter($lines, fn($line) => trim($line) != "");
        return join(PHP_EOL . " * ", $lines) . PHP_EOL . "*/";
    }

    private function makeTestContent(string $file, string $content): string
    {
        $testName = $this->extractFileName($file);
        $nameSpace = $this->extractTestDirectory($file);
        return <<<MS
        <?php

        namespace $nameSpace;

        use Tests\TestCase;

        $content

        class $testName extends TestCase {
            public function testUnit()
            {
                // do testing
            }
        }
        MS;
    }

    private function extractFileName(string $file): string
    {
        $slashPos = mb_strrpos($file, "/");
        $backSlashPos = mb_strrpos($file, "\\");
        if ($slashPos !== false || $backSlashPos !== false) {
            return mb_substr($file, ($slashPos ?: $backSlashPos) + 1);
        } else {
            return $file;
        }
    }

    private function extractTestDirectory(string $file): string
    {
        $slash = mb_strrchr($file, "\\", true);
        $backSlash = mb_strrchr($file, "/", true);
        $folder = "";
        if ($slash || $backSlash) {
            $folder = "\\" . ($slash ?: $backSlash);
        }
        return "Tests\\Frature$folder";
    }

    private function extractFileFolder(string $file): string
    {
        $slash = mb_strrchr($file, "\\", true);
        $backSlash = mb_strrchr($file, "/", true);
        $folder = "";
        if ($slash || $backSlash) {
            $folder = DIRECTORY_SEPARATOR . ($slash ?: $backSlash);
        }
        return $folder;
    }

    private function ensureDirectoryExists(string $directory): void
    {
        if (!$this->filesystem->isDirectory($directory)) {
            $this->filesystem->makeDirectory($directory, 0775, true);
        }
        ;
    }

    private function writeContent(string $path, string $file, string $extension, string $content, bool $append = false): void
    {
        $fullPath = "$path$file.$extension";
        if ($append == true) {
            $content = str_repeat(PHP_EOL, 2) . $content;
            $this->filesystem->append($fullPath, $content);
        } else {
            $this->filesystem->put($fullPath, $content);
        }
    }

}
