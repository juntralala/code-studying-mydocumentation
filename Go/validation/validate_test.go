package main 

import (
	"fmt"
	"github.com/go-playground/validator"
	"testing"
)

type Person struct {
	Name string		`validate:"required,min=4,max=255"`
	Age int 		`validate:"min=18"`
	Contact Contact	`validate:"required"`
	Hobbies []string`validate:"required,dive,min=4"` // slice/array/map tidak otomatis nested, jadi perlu validation tag dive
}

type Contact struct {
	Email string `validate:"required,email"`
	Telepon string `validate:"required,min=10,max=20"`
}


func TestValidate(t *testing.T) {
	var vld *validator.Validate = validator.New()
	
	var ujun Person = Person{
		Name: "uju",
		Contact: Contact{
			Email: "ujun.email.com",
			Telepon: "124141",
		},
		Age: 16,
		Hobbies: []string{
			"Cod",
			"Makan",
		},
	}
	
	err := vld.Struct(ujun)
	if err != nil {
		if validationErrors, ok := err.(validator.ValidationErrors); ok {
			fmt.Println(validationErrors)
		}
		fmt.Printf("%T\n", err)
	}
}