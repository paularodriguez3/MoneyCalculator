# **Money Calculator**
Este proyecto implementa un conversor de divisa en Java, siguiendo un diseño modular y organizado en varios paquetes. A continuación, se describe la estructura del proyecto y cómo ejecutarlo.

## **Estructura del Proyecto**

### **cli:** Contiene las clases relacionadas con la interfaz de línea de comandos.

- **CliCurrencyDialog.java:** Implementa la interfaz CurrencyDialog para solicitar al usuario una divisa a través de la línea de comandos.
- **CliMoneyDialog.java:** Implementa la interfaz MoneyDialog para solicitar al usuario una cantidad y una divisa a través de la línea de comandos.

### **control:** Contiene las clases relacionadas con el control de la aplicación y la ejecución de comandos.

- **Command.java:** Interfaz que define el método execute para ejecutar un comando.
- **ExchangeMoneyCommand.java:** Implementa la interfaz Command para realizar el intercambio de dinero.

### **fixerws:** Contiene las clases relacionadas con la integración con la API de Fixer para obtener tasas de cambio.

- **FixerAPI.java:** Clase con la clave de acceso a la API de Fixer.
- **FixerCurrencyLoader.java:** Implementa la interfaz CurrencyLoader para cargar las monedas desde la API de Fixer.

### **mock:** Contiene clases de implementación simulada para pruebas.

- **MockCurrencyDialog.java:** Implementa la interfaz CurrencyDialog con datos simulados.
- **MockCurrencyLoader.java:** Implementa la interfaz CurrencyLoader con datos simulados.
- **MockExchangeRateLoader.java:** Implementa la interfaz ExchangeRateLoader con datos simulados.
- **MockMoneyDialog.java:** Implementa la interfaz MoneyDialog con datos simulados.
- **MockMoneyDisplay.java:** Implementa la interfaz MoneyDisplay para mostrar resultados simulados.

### **model:* Contiene las clases que representan el modelo de datos.

- **Currency.java:** Clase que representa una divisa con código y nombre.
- **ExchangeRate.java:** Clase que representa una tasa de cambio entre dos divisas en una fecha específica.
- **Money.java:** Clase que representa una cantidad de dinero en una divisa.

### **swing:** Contiene las clases relacionadas con la interfaz gráfica de usuario basada en Swing.

- **SwingCurrencyDialog.java:** Implementa la interfaz CurrencyDialog para solicitar al usuario una divisa mediante una interfaz gráfica de usuario Swing.
- **SwingMain.java:** Clase principal que inicia la aplicación Swing y crea la interfaz gráfica de usuario.
- **SwingMoneyDialog.java:** Implementa la interfaz MoneyDialog para solicitar al usuario una cantidad y una divisa mediante una interfaz gráfica de usuario Swing.
- **SwingMoneyDisplay.java:** Implementa la interfaz MoneyDisplay para mostrar resultados en una interfaz gráfica de usuario Swing.
