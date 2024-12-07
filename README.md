# Aplicación Convertidor de Monedas

Este proyecto es una aplicación que permite convertir valores entre diferentes monedas utilizando una API de conversión de monedas. La aplicación permite al usuario seleccionar dos monedas (una de origen y una de destino) e ingresar una cantidad, para obtener el valor convertido en tiempo real.

## Funcionalidades

- Conversión de monedas en tiempo.
- Soporte para múltiples monedas.

## Requisitos

Para ejecutar esta aplicación, necesitas tener instalados los siguientes elementos:

- **Clave API** de un servicio de conversión de monedas (por ejemplo, [exchangerate-api.com](https://www.exchangerate-api.com/)).

## Instalación

1. Clona este repositorio en tu máquina local:

    ```bash
    git clone https://github.com/ARuizMontana/one-exchange-api.git
    ```

2. Crea un archivo `.env` en el directorio raíz del proyecto con tu clave API. El archivo debe verse así:

    ```env
    API_KEY=tu_clave_api_aqui
    ```

3. Inicia la aplicación:

## Uso

1. Al iniciar la aplicación, verás un menu en la consola donde podrás seleccionar e ingresar la cantidad a convertir.

## API de Conversión de Monedas

La aplicación utiliza la API de [ExchangeRate-API](https://www.exchangerate-api.com/), que proporciona tasas de cambio en tiempo real.

### Endpoints Utilizados:

- **Para convertir una cantidad de una moneda a otra**

    ```bash
    GET GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP
    ```

  Este endpoint devuelve la tasa de cambio actual de USD a otras monedas.


## Licencia

Este proyecto está bajo la Licencia MIT - consulta el archivo [LICENSE](LICENSE) para más detalles.

