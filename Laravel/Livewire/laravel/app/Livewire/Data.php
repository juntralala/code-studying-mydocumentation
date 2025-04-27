<?php

namespace App\Livewire;

use Illuminate\Http\Response;
use Livewire\Component;

class Data extends Component
{
    public int $id;
    public string $data;

    public function mount(int $id)
    {
        $datas = [
            10 => "Wortel",
            20 => "Bayam",
            30 => "Kentang",
        ];

        $this->id = $id;
        $this->data = $datas[$id] ?? "Data tidak ditemukan";
    }

    public function render()
    {
        return view('livewire.data')
            ->response(function (Response $response) {
                $response->header('X-Custom-Header', "Ini Kustom Header");
            });
    }
}
