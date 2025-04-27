<?php

namespace App\Livewire;

use Livewire\Component;

class ModelLive extends Component
{
    public $title = "live c input";

    public function render()
    {
        return view('livewire.model-live');
    }
}
