# AeroCRS File System
This project is a simple file system implementation using Java language. It simulates the behavior of a file system, with directories, subdirectories, files, and categories.

## Requirements
In order to run this project, you need to have the following software installed on your machine:

Java Development Kit (JDK) 8 or later
Maven
## How to Run
To run this project, follow the steps below:

- Clone the repository:
```sh
git clone https://github.com/pauloberezini/AeroCRS-File-System.git
```
Navigate to the project root directory:
```sh
cd AeroCRS-File-System/
```
- Build the project with Maven:
```sh
mvn package
```
- Run the project:
```sh
java -cp target/AeroCRS-File-System-1.0-SNAPSHOT.jar com.berezini.controller.MainController
```
## How to Use
After running the project, you will see a command-line interface (CLI) where you can execute the available commands. These commands are:

addDirectory [directory name] [directory id] [category] [parent directory id]: adds a directory to the file system with the given name, ID, category, and parent directory ID.
addFile [file name] [file id] [category] [parent directory id]: adds a file to the file system with the given name, ID, category, and parent directory ID.
removeDirectory [directory id]: removes the directory with the given ID from the file system.
removeFile [file id]: removes the file with the given ID from the file system.
showAll: displays the entire file system hierarchy.
## How to Test
This project includes JUnit tests for the FileSystem class. To run the tests, follow the steps below:

- Navigate to the project root directory:
```sh
cd AeroCRS-File-System/
```
- Run the tests with Maven:
```sh
mvn test
```
## Contributors
[Paulo Berezini]
## License
This project is licensed under the MIT License.

[Paulo Berezini]: <https://github.com/pauloberezini>
