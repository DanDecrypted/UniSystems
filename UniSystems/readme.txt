There is a user created for access to the system.
Username: admin
Password: password
When you load the login form which is the entry point of the application, the test data should build itself into the directory of %CurrentDirectory%/Data/
In here you will find 4 data files: 
Admininstrators.dat
StaffMembers.dat
Cars.dat
Loans.dat
Which are all object dumps of array lists containing the data of the system. 
If for any reason the data fails to load, if you have a directory called "data" you can delete this directory and the data should rebuild itself into a usable state.