<?php

namespace Tests\Feature;

use App\Models\Orang;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class CostumEchoHandlerTest extends TestCase {
    public function testEcho(): void {
        $orang = new Orang();
        $orang->nama = "ujun";
        $orang->umur = 18;

        $this->view('costum-echo-handler', ['orang' => $orang])
            ->assertSeeText("ujun : 18");
    }
}
