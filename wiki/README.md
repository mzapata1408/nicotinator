# Nicotinator's Wiki

Use this space to document things from the application such as installation process or run procedures.

# Markdown quick reference

[Markdown cheat sheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet#links)


# MySql installation and configuration

In Linux Ubuntu run the commands

```shell
sudo apt-get update -y
sudo apt-get install mysql-server
sudo mysql_secure_installation
```

Then start a new command line session in MySql to add the application user

```shell
mysql -u root -p
```

```shell
GRANT ALL PRIVILEGES ON *.* TO 'nicotinator'@'localhost' IDENTIFIED BY 'a';
```

Then quit the session and login again with the new user to verify it worked.

```shell
mysql -u nicotinator -p
```

Now we need to create a new database for the application in order to run the initial scripts to set up the database as follows:

```shell
mysql -u nicotinator -p
CREATE DATABASE nicotinatordb;
```

To import any scripts to the newly created DB you can use the command:

```shell
mysql -u nicotinator -p nicotinatordb < mysql-script.sql
```

Check this link for a quick reference to [MySql commands](https://www.digitalocean.com/community/tutorials/a-basic-mysql-tutorial)