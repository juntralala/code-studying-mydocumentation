package main

import "fmt"
import "regexp"

func main() {
	var pattern *regexp.Regexp = regexp.MustCompile("u[a-z]*n")

	fmt.Println(pattern.MatchString("ujun"))
	fmt.Println(pattern.MatchString("ozon"))
	fmt.Println(pattern.FindAllString("ujun ujon uzon junaidi", 10))
}