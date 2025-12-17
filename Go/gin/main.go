package main

import (
	"fmt"
	"github.com/gin-gonic/gin"
	"os"
)

func main() {
	os.Setenv("PORT", "8000")
	app := gin.Default()

	app.GET("/", func(c *gin.Context) {
		c.JSON(200, gin.H{"message": "Hello World"})
	})
	app.GET("/hello", func(c *gin.Context) {
		// name := c.Query("name")
		name := c.DefaultQuery("name", "anonym")
		c.JSON(200, gin.H{"message": fmt.Sprintf("Hello %s", name)})
	})
	app.GET("/inspect", func(c *gin.Context) {
		c.JSON(200, c.Request.Header)
	})

	err := app.Run()
	if(err != nil) {
		panic(err)
	}
}