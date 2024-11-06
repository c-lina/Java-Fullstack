/*

STOP! Don't compare React Interfaces to Java Interfaces

In Typescript and React, Interfaces behave more like Java Model CLasses - they model data.
We'll be modeling some User data based off the fields in the Interface

Our UserComponent will send data of UserIntefaces type of UserInfoComponent

*/

export interface UserInterface {
    firstName:string,
    lastName:string,
    userName:string,
    email?:string
}

/* 

"?" just means that the variable is optional. So it doesn't require a value at any point
I typically make every variable optional unless I know it'll be required

*/