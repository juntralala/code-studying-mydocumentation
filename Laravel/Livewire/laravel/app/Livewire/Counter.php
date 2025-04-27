<?php

namespace App\Livewire;

use Livewire\Attributes\Title;
use Livewire\Component;

class Counter extends Component
{
    public $counter = 0;

    #[Title('Counter Page')]
    public function render()
    {
        return view('livewire.counter')
            ->with('author', "Junaidi");
    }

    public function count(){
        $this->counter++;
    }
}
