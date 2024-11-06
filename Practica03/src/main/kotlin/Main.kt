fun main() {
    val smartTv = SmartTvDevice("Android TV", "Entertainment")
    val smartLight = SmartLightDevice("Google Light", "Utility")
    val smartHome = SmartHome(smartTv, smartLight)

    // Encender la TV y cambiar de canal
    smartHome.turnOnTV()
    smartHome.changeTVChannelToNext()
    smartHome.changeTVChannelToPrevious()

    // Aumentar y disminuir el volumen de la TV
    smartHome.increaseTVVolume()
    smartHome.decreaseTVVolume()

    // Imprimir información de la TV
    smartHome.printSmartTvInfo()

    // Encender la luz, aumentar y disminuir el brillo
    smartHome.turnOnLight()
    smartHome.increaseLightBrightness()
    smartHome.decreaseLightBrightness()

    // Imprimir información de la luz
    smartHome.printSmartLightInfo()
}


open class SmartDevice1(val name: String, val category: String) {
    var deviceStatus = "online"
    open val deviceType = "unknown"

    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }

    // Nuevo método para imprimir la información del dispositivo
    fun printDeviceInfo() {
        println("Device Name: $name")
        println("Category: $category")
        println("Device Type: $deviceType")
        println("Status: $deviceStatus")
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) : SmartDevice1(name = deviceName, category = deviceCategory) {
    override val deviceType = "Smart TV"

    var speakerVolume = 2
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    var channelNumber = 1
        set(value) {
            if (value in 0..200) {
                field = value
            }
        }

    // Método para aumentar el volumen
    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    // Nuevo método para disminuir el volumen
    fun decreaseVolume() {
        if (speakerVolume > 0) {
            speakerVolume--
            println("Speaker volume decreased to $speakerVolume.")
        } else {
            println("Speaker volume is already at the minimum.")
        }
    }

    // Método para avanzar al siguiente canal
    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    // Nuevo método para retroceder al canal anterior
    fun previousChannel() {
        if (channelNumber > 1) {
            channelNumber--
            println("Channel number decreased to $channelNumber.")
        } else {
            println("You are already on the first channel.")
        }
    }

    override fun turnOn() {
        super.turnOn()
        println("$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to $channelNumber.")
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}


class SmartLightDevice(deviceName: String, deviceCategory: String) : SmartDevice1(name = deviceName, category = deviceCategory) {
    override val deviceType = "Smart Light"

    var brightnessLevel = 0
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    // Método para aumentar el brillo
    fun increaseBrightness() {
        if (brightnessLevel < 100) {
            brightnessLevel++
            println("Brightness increased to $brightnessLevel.")
        } else {
            println("Brightness is already at the maximum level.")
        }
    }

    // Nuevo método para disminuir el brillo
    fun decreaseBrightness() {
        if (brightnessLevel > 0) {
            brightnessLevel--
            println("Brightness decreased to $brightnessLevel.")
        } else {
            println("Brightness is already at the minimum level.")
        }
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}


class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {
    fun turnOnTV() {
        smartTvDevice.turnOn()
    }

    fun turnOffTV() {
        smartTvDevice.turnOff()
    }

    fun increaseTVVolume() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.increaseSpeakerVolume()
        } else {
            println("TV is off. Cannot increase volume.")
        }
    }

    // Método para disminuir el volumen de la TV
    fun decreaseTVVolume() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.decreaseVolume()
        } else {
            println("TV is off. Cannot decrease volume.")
        }
    }

    // Método para avanzar al siguiente canal de la TV
    fun changeTVChannelToNext() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.nextChannel()
        } else {
            println("TV is off. Cannot change channel.")
        }
    }

    // Método para retroceder al canal anterior de la TV
    fun changeTVChannelToPrevious() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.previousChannel()
        } else {
            println("TV is off. Cannot change channel.")
        }
    }

    // Método para imprimir la información de la TV
    fun printSmartTvInfo() {
        smartTvDevice.printDeviceInfo()
    }

    fun turnOnLight() {
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        smartLightDevice.turnOff()
    }

    // Método para aumentar el brillo de la luz
    fun increaseLightBrightness() {
        if (smartLightDevice.deviceStatus == "on") {
            smartLightDevice.increaseBrightness()
        } else {
            println("Light is off. Cannot increase brightness.")
        }
    }

    // Método para disminuir el brillo de la luz
    fun decreaseLightBrightness() {
        if (smartLightDevice.deviceStatus == "on") {
            smartLightDevice.decreaseBrightness()
        } else {
            println("Light is off. Cannot decrease brightness.")
        }
    }

    // Método para imprimir la información de la luz
    fun printSmartLightInfo() {
        smartLightDevice.printDeviceInfo()
    }

    fun turnOffAllDevices() {
        turnOffTV()
        turnOffLight()
    }
}





