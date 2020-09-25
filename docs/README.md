# USER GUIDE

1. Introduction
2. Quick Start
3. Features
   1. Adding todo: `todo`
   2. Adding deadline: `deadline`
   3. Adding event: `event`
   4. Viewing current tasks: `list`
   5. Viewing tasks on a specific date: `date`
   6. Marking a task as done: `done`
   7. Deleting a task: `delete`
   8. Finding a task containing specific words: `find`
   9. Exiting the chatbot: `bye`
4. Command Summary

### 1. Introduction

Duke is a desktop chatbot, optimised for use via a Command Line Interface (CLI). This application aims to help user store tasks and trace the status of tasks.

### 2. Quick Start

1. Ensure you have Java 11 or above installed in your Computer
2. Download the latest ip.jar from Github: https://github.com/killingbear999/ip.
3. Copy the file to the folder you want to use as the home folder.
4. Type the command in the command box and press Enter to execute it.  
   E.g. Typing `list` and pressing Enter for Duke to display all current tasks on the list.
5. Refer to the Features below for details of each command.

### 3. Features

1. Adding todo: `todo`
   1. User can add a task of a 'todo' type into the list.
   2. Format: todo [-d DESCRIPTION]
   3. Example: todo borrow book
2. Adding deadline: `deadline`
   1. User can add a task of a 'deadline' type into the list.
   2. Format: deadline [-d DESCRIPTION] /by [-t timing] OR deadline [-d DESCRIPTION] /by [-d yyyy-mm-dd]
   3. Examples: deadline borrow books /by Sunday 6pm OR deadline borrow books /by 2020-07-21
3. Adding event: `event`
   1. User can add a task of a 'event' type into the list.
   2. Format: event [-d DESCRIPTION] /at [-t timing] OR event [-d DESCRIPTION] /at [-d yyyy-mm-dd]
   3. Examples: event borrow books /at Sunday 5-6pm OR event borrow books /at 2020-07-21
4. Viewing current tasks: `list`
   1. User can view current tasks on the list as well as their corresponding status.
   2. Format: `list`
   3. Example: list
5. Viewing tasks on a specific date: `date`
   1. User can view current tasks on a specific date if available
   2. Format: date [-d MON DAY YEAR]
   3. Example: date Jul 21 2020
6. Marking a task as done: `done`
   1. User can change the status of a specific task by marking it as done.
   2. Format: done [-n NUMBER]
   3. Example: done 1
7. Deleting a task: `delete`
   1. User can delete a specific task from the list
   2. Format: delete [-n NUMBER]
   3. Example: delete 1
8. Finding a task containing specific words: `find`
   1. User can find a task by searching a keyword
   2. Format: find [-d DESCRIPTION]
   3. Example: find book
9. Exiting the chatbot: `bye`
   1. User can exit Duke by typing 'bye' and Duke will automatically update current tasks to the local disk
   2. Format: bye
   3. Example: bye

### 4. Command Summary

ACTION | FORMAT & EXAMPLE
--------------------------------|--------------------------------------------------------------
todo | todo [-d DESCRIPTION]  (e.g. todo borrow book)
deadline | deadline [-d DESCRIPTION] /by [-t timing] OR deadline [-d DESCRIPTION] /by [-d yyyy-mm-dd] (e.g. deadline borrow books /by Sunday 6pm OR deadline borrow books /by 2020-07-21)
event |  event [-d DESCRIPTION] /at [-t timing] OR event [-d DESCRIPTION] /at [-d yyyy-mm-dd] (e.g. event borrow books /at Sunday 5-6pm OR event borrow books /at 2020-07-21)
list | list
date | date [-d MON DAY YEAR] (e.g. date Jul 21 2020)
done | done [-n NUMBER] (e.g. done 1)
delete | delete [-n NUMBER] (e.g. delete 1)
find | find [-d DESCRIPTION] (e.g. find book)
bye | bye
