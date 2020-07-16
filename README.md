# Employee Management System
> This Employee Management System is created using Java, with SQL and JDBC for database integration and a GUI made from Swing components.

## Video overview
For a video overview and walkthrough of the system, [click here.](https://youtu.be/4W24xYVc0Hc)

## What have I learnt?
Whilst doing this project I have taught myself some new skills, these are:
* Knowledge in databases, such the differences between `RDBMS` and `DBMS`
* Basic `SQL Syntax` along with how to use `SQL Workbench`
* `Swing` for Java for creating `GUIs` by using `LayoutManagers` without the help of a design window
* What `JDBC` does and how it is used
* Enhanced my `OOP` knowledge
* Understood the importance of `planning a project`
* Gained understanding and insight into the `software development process`
* How to create and use a `Javadoc`

## Features
> This project has two sides, an `HR` side and a `Non HR`.

### Login Page
* Login to your account on the `HR side` or the `Non HR` side based on your account access level

### The HR features includes:
#### Employee Details
* Employee detail `search` and `edit`

#### Employee Actions
* `Add employee` and `create a login` so they can access the system
* `Remove employee` so their details are removed and can no longer access the system

#### Holidays
* `Accept/Decline` holiday requests made by a `Non HR member`
* `View all` Accepted, Declined and Pending holidays
* `Search` for a specific employee's requested holidays

#### Overtime
* `Accept/Decline` overtime request, reflects automatically in the employees salary
* `View` overtime requests made by `individuals`, or for the `whole system`
* `Search` for a specific employee's requested overtimes

#### Meetings
* `Accept/Decline` requests for a meeting
* `View` meetings made by `all employees` or view a `single employee`
* `Search` for a specific employee's requested meetings
***
### The Non HR features includes:
#### Employee Details
* `Edit` your own details

#### Holidays
* `Create` a holiday request for HR to accept
* `View` your `Accepted`, `Declined` and `Pending` holidays

#### Overtime
* `Submit` overtime request, reflects automatically in your salary
* `View` your submitted overtime requests

#### Meetings
* `Request` a meeting for HR to `accept` or `decline`
* `View` meetings made by yourself and see their `current status`
> When an employee who is not a member of HR makes a request, a meeting for example, the request will be pending, and a member of HR can choose to accept or decline it

## Setup and Installation
1. Clone repository to download all files
2. Make sure you have JDBC installed and connected to your SQL server using `port 2206`
3. Go to the package `Database` then follow to the file `LoginInformation`. Here enter your root SQL password
4. Run the `CreateDatabase` SQL file, then the `GUIRunner` file within the `GUI` package
5. Enjoy messing around with the project!
