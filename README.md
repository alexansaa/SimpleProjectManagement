<a name="readme-top"></a>

# 📗 Table of Contents

- [📖 About the Project](#about-project)
  - [🛠 Built With](#built-with)
    - [Tech Stack](#tech-stack)
    - [Key Features](#key-features)
- [💻 Getting Started](#getting-started)
  - [Setup](#setup)
  - [Prerequisites](#prerequisites)
  - [Install](#install)
  - [Usage](#usage)
  - [Run tests](#run-tests)
  - [Deployment](#triangular_flag_on_post-deployment)
- [👥 Authors](#authors)
- [🔭 Future Features](#future-features)
- [🤝 Contributing](#contributing)
- [⭐️ Show your support](#support)
- [🙏 Acknowledgements](#acknowledgements)
- [📝 License](#license)

# 📖 [Simple Project Manager] <a name="about-project"></a>

**[Simple Project Manager]**
The Simple Project Manager app keeps track of all your projects, tasks, comments and users. It will allow you to create new projects, add new task to the project, assign users to tasks, and adding new comments to tasks. Users are managed also by the program, so the application is stand alone. You can create an executable file out of the raw code on this repo. 

This application uses serialized local files to keep record of data stored. Instead of using al SpringBoot functionalities, this applications defines its own class for managing stored data into serialized files, which will map to objects arrays used by the application.

## 🛠 Built With <a name="built-with"></a>

### Tech Stack <a name="tech-stack"></a>

<details>
  <summary>Client</summary>
  <ul>
    <li><a href="https://www.java.com/es/download/ie_manual.jsp">Java</a></li>
    <li><a href="https://spring.io/projects/spring-boot">Spring Boot</a></li>
    <li><a href="https://vaadin.com/">Vaadin</a></li>
  </ul>
</details>

### Key Features <a name="key-features"></a>

- **[Models]**
-- Comment
-- Project
-- Task
-- User
- **[Controllers]**
-- appDtatManipulator
- **[Views]**
-- home
-- login
-- Create and Edit forms
-- Projects, Tasks, Comments Pages

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## 💻 Getting Started <a name="getting-started"></a>

To get a local copy up and running, follow these steps.

### Prerequisites

In order to run this project you need:

- Java installed on your PC globally

### Setup

Clone this repository to your desired folder:

```sh
  cd my-folder
  git https://github.com/alexansaa/SimpleProjectManagement.git
```

### Install

Install this project with:

The project does not require any further installation.
You can get an executable file out of this raw code.

### Usage

To run the project, execute the following command:

-- Use Application.java as entry point to the application when running the program
-- application UI will pop up on a browser tab, so you can start using the application
-- "Usuario1" & "Pass1" are used as credetials for a mock Admin user
-- "Usuario2" & "Pass1" are used as credetials for a mock Client user
-- You can create your own username and password if the given username has not been registered previously into the program data

### Deployment

You can deploy this project using:
Coming Soon

<!--
Example:

```sh

```
 -->

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- AUTHORS -->

## 👥 Authors <a name="authors"></a>

👤 **Kleber Saavedra**

- GitHub: [@alexander](https://github.com/alexansaa)
- LinkedIn: [Kleber Saavedra](https://www.linkedin.com/in/alexander-saavedra-garcia/)

👤 **Pablo Arcos**

- GitHub: [@alexander](https://github.com/Pablin72)
- LinkedIn: [Pablo Arcos](https://www.linkedin.com/in/pablo-arcos-559348211/)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- FUTURE FEATURES -->

## 🔭 Future Features <a name="future-features"></a>

- [ ] **[DataBase information preservation]**
- [ ] **[Implement Authentication and Authorization]**
- [ ] **[Deploy the application]**

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTING -->

## 🤝 Contributing <a name="contributing"></a>

Contributions, issues, and feature requests are welcome!

Feel free to check the [issues page](https://github.com/alexansaa/SimpleProjectManagement/issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## ⭐️ Show your support <a name="support"></a>

If you like this project, please give it a star on GitHub

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## 🙏 Acknowledgments <a name="acknowledgements"></a>

I would like to thank Karo Quinaloa for letting me work with one or her clients

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- LICENSE -->

## 📝 License <a name="license"></a>

This project is [MIT](./LICENSE.md) licensed.

<p align="right">(<a href="#readme-top">back to top</a>)</p>
