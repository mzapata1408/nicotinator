
# Nicotinator's wiki page

User this space to document things from the application such as installation process or run procedures.

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