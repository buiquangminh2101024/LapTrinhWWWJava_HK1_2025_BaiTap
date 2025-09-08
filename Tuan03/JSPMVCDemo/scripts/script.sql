USE jsp_mvc;

CREATE TABLE User (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      first_name VARCHAR(15) CHARACTER SET UTF8MB4,
                      last_name VARCHAR(15) CHARACTER SET UTF8MB4,
                      email VARCHAR(50),
                      pwd VARCHAR(50),
                      dob DATE,
                      gender VARCHAR(6)
)