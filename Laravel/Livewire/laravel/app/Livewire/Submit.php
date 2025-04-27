<?php

namespace App\Livewire;

use Livewire\Component;

class Submit extends Component
{
    public $title = "Ini Judul";
    
    public function render()
    {
        return view('livewire.submit');
    }

    public function setTitle(){
        // do something
        // like save data to db or others
    }
}
