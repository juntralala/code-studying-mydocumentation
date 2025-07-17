<?php

namespace UjunAlRantaui\PHP\Logging\ResetHandlerDanProcessor;

/** ResetableInterface
 * Saat kita menggunakan Handler dan Processor, kadang ada beberapa Handler dan Processor yang menyimpan
   datanya di memory
 * Jika proses object Logger mengikuti alur hidup Web Request, hal itu aman aman saja karena setelah web
   request selesai, semua data akan dihapus dari memory
 * Namun jika kita melakukan perkerjaan yang lama, misal long running job, maka akan sangat disarankan 
   untuk secara regular melakukan reset Handler dan Processor
 * Beberapa Handler dan Processor merupakan implementasi ResetableInterface yang memiliki method reset()
   untuk melakukan reset data
 */

class ResetableInterface_ {
}