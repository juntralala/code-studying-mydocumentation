package main

import (
	"net/http"
	"os"
	"io"
)

func main() {
	var handler = http.NewServeMux()
	handler.HandleFunc("/", func(res http.ResponseWriter,req *http.Request) {
		res.Write([]byte("Ini Root Path"))
	})
	handler.HandleFunc("/go.mod", func(res http.ResponseWriter,req *http.Request) {
		file, _ := os.Open("go.mod")
		io.Copy(res, file)
	})

	server := http.Server{
		Addr: "localhost:8080",
		Handler: handler,
	}
	err := server.ListenAndServe()
	if(err != nil) {
		panic(err)
	}
}