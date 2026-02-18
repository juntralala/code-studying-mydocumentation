// EventTarget <- Node <- Element <- HTMLElement

/* node events
startselection                  <- not widely avalable on browsers btw
*/

/* Element events
input
beforeinput
beforematch                     <- saat element tampil karna fitur pencarian browser
fullscreenchange
fullscreenerror
wheel

// clipboard
copy
paste
cut

// FocusEvent
focus
blur
focusin             <- setelah focus
focusout            <- setelah blur

// KeyBoardevent
keydown
keyup

// scroll
scroll
scrollend

// MouseEvent
mousemove
mouseover
mouseenter
mouseout
mouseleave
mousedown
mouseup
click                 // <- actually this was a PointerEvent
dblclick
contextmenu

// PointerEvent
pointermove
pointerdown
pointerup
pointercancel
pointerover
pointerenter
pointerleave
pointerout

//
transitionrun             // <- transisi dibuat, tidak harus jalan dulu baru ketrigger
transitionstart
transitionend
transitioncancel
animationstart
animationend
animationcancel
animationiteration
*/

/* HTMLElement events
load
change
error               <- fail to load from src="" atribute, like in <img src=""/>

// DragEvent
drag                <- fire continuesly, when moved
dragstart
dragend
drop
dragenter
dragleave
dragover             <- fire continuesly, not like mouseover that only fire once time (nggak ada event dragout juga btw)
*/

/* HTMLInputElement
// nggak banyak yg berguna
select              <- select/block teks pada input
secelectionchange
cancel          <- batal milih file
invalid         <- untuk built in validation html form pakai pattern atau required
*/

/* window (beberapa)
online
offline
beforeprint
afterprint
*/