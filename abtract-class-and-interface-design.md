# Exercise: Managing Electronic Devices
## Problem:
Imagine you are developing a system to manage electronic devices such as TV, Computer, and Phone. All of these devices can be turned on and turned off (start, stop), and they can also connect to Wi-Fi (a feature common to all devices).

## Requirements:

- Interface `Connectable`: Contains the method `connectToWiFi()` to allow devices to connect to Wi-Fi.
- Abstract class `ElectronicDevice`: This abstract class will have common properties for all electronic devices like `name` and `status` (whether it is on or off).
- Classes `TV`, `Computer`, and `Phone` will inherit from `ElectronicDevice` and implement the methods from the `Connectable` interface.
