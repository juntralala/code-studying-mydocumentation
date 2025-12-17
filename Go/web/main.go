package main

import (
	"net/http"
)

type MyHandler struct {}

func (this MyHandler) ServeHTTP(res http.ResponseWriter,req *http.Request) {
	res.Write([]byte("OK"))
}

func main() {
	var handler http.Handler = MyHandler{}

	server := http.Server{
		Addr: "localhost:8080",
		Handler: handler,
	}
	err := server.ListenAndServe()
	if(err != nil) {
		panic(err)
	}
}