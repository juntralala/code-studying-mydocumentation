<?php

namespace UjunAlRantaui\PHP\Login\Management\App;
use PHPUnit\Framework\TestCase;

function header($value) {
    echo $value;
}

class ViewTest extends TestCase {

    protected function setUp(): void {
        putenv("mode=test");
    }

    function testRender():void {
        View::render("Home/index", [
            "title" => "PHP Login Management"
        ]);

        $this->expectOutputRegex("[PHP Login Management]");
        $this->expectOutputRegex("[html]");
        $this->expectOutputRegex("[body]");
        $this->expectOutputRegex("[Login Management]");
        $this->expectOutputRegex("[Login]");
        $this->expectOutputRegex("[Register]");
    }

    function testRedirect(): void {
        View::redirect("Location: /");

        $this->expectOutputRegex("/Location: \//");
    }
}