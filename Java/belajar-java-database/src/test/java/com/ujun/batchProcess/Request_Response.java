package com.ujun.batchProcess;

/**
 * Secara default, komunikasi antar database dan applikasi Java kita adalah request dan response
 * Artinya, setiap kali kita mengirim perintah SQl, maka aplikasi kita akan menunggu sampoi database melakukan response
   dari perintah SQL tersebut
 * Prosess tersebut kadang terlalu chatty jikalau misal kita ingin mengirim data secara banya ke database
 */ // misal import jutaan data excel ke database

public interface Request_Response {
}
