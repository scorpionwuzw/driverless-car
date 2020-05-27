# **Description of driverless car project**

### **the main project structure of driverless car project**

**Application.class:** system entry point. Firstly, it will get car's current position, then init car park size. Meanwhile, it will set step times and set orientation which the car will move. Finally, it will start to move the car to the target position, at the same time, it will print log on console and log file

**DriverlessCarService:** it is a interface which defines car move action and get car's current position that contains positionX, positionY and orientation

**car_park_size.txt:** it is configurable and contains the car park length and width. the car park size configuration can be configured by other form like configuration center Apollo which produced by ctrip or yml, properties file

**current_position.txt:** it is configurable and contains the car positionX, positionY and orientation. the car park size configuration can be configured by other form like configuration center Apollo which produced by ctrip or yml, properties file


### **the core car move algorithm**
Imaging the car park as a rectangle whose length and width can be changed. And the car is like a point which can move in the rectangle. once the car moves out of the rectangle, the system will throw a signal.
We can use the coordinates to mark the rectangle and the car as good as a math problem to compare the length and width

### **how to run the system**
What you need to do is set the steps and the orientation the car will move using variable steps and orientation in main method, Application.class, then run the Application.class. 
When the application is finished it will print message on console and write message in log file. 
The steps and orientation which the car will move are configurable. Also the car park size and the car start position can be configurable in files
