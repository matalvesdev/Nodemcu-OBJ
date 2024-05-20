# Desenvolvimento de um Medidor de Temperatura Corporal Utilizando a Plataforma NodeMCU

## Introdução
O projeto consiste no desenvolvimento de um medidor de temperatura corporal utilizando a plataforma NodeMCU. O dispositivo será capaz de medir a temperatura corporal do usuário por meio de um sensor de temperatura e exibir os resultados em um display. Além disso, será implementado um sistema de alerta para indicar febre, baseado em uma faixa de temperatura configurável. O objetivo é criar uma solução acessível e de fácil utilização para monitorar a temperatura corporal, especialmente em contextos de saúde e segurança.
## Software
```
#include <Wire.h>
#include <Adafruit_MLX90614.h>

Adafruit_MLX90614 mlx = Adafruit_MLX90614();

void setup() {
  Serial.begin(9600);
  Serial.println("MLX90614 Test");
  mlx.begin();
}

void loop() {
  float tempAmbiente = mlx.readAmbientTempC();

  if (!isnan(tempAmbiente)) {
    Serial.print("Temperatura ambiente: "); 
    Serial.print(tempAmbiente);
    Serial.println(" °C");
  } else {
    Serial.println("Erro ao ler a temperatura!");
  }

  delay(1000);
}
```
## Hardware utilizado

1. **Módulo Sensor de Temperatura Infravermelho GY-906 MLX90614**:

<img src="https://http2.mlstatic.com/D_NQ_NP_612379-MLB31142357476_062019-O.webp" alt="" width="200" style="margin-left: 20px"/>

O módulo sensor de temperatura infravermelho GY-906 MLX90614 é um sensor digital sem contato que permite a medição de temperatura de objetos à distância. O sensor possui um alcance de medição de -70°C a 380°C e uma precisão de ±1°C.

O sensor GY-906 MLX90614 será utilizado para medir a temperatura corporal do usuário.

2. **Cabos Jumper Wire 20cm 40 Fios Macho Macho**:

<img src="https://cdn.awsli.com.br/600x450/710/710156/produto/29078864/e990ed38ad.jpg" alt="" width="200" style="margin-left: 20px"/>

Os cabos jumper wire macho-macho são utilizados para conectar componentes eletrônicos em protoboards ou outros dispositivos. Os cabos possuem 20cm de comprimento e são compostos por 40 fios de diferentes cores.

Os cabos jumper wire serão utilizados para conectar os componentes do protótipo. 

3. **Protoboard 830 Pontos Breadboard Matriz de Contato**:

<img src="https://http2.mlstatic.com/D_NQ_NP_719746-MLU73788403668_012024-O.webp" alt="" width="200" style="margin-left: 20px"/>

A protoboard é uma placa de desenvolvimento que permite a prototipagem rápida de circuitos eletrônicos. A protoboard possui diversos furos que permitem a conexão de componentes através de cabos jumper wire.

A protoboard será utilizada para montar o protótipo do medidor de temperatura corporal.

4. **Display LCD 16x2**:

<img src="https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcQhxQyAFhUal0qM2KSG_gikFV6NQN7Ld9uebBsFlt1EG1nNf0k8aCTnhxL49YG2ayaYYV5TcKqYGPHki4TloY0Dz_ovi5rsVTrLPwbp4krD0TU9QgTA2PgYuaQBXom-AUlar9-OG2I&usqp=CAc" alt="" width="200" style="margin-left: 20px"/>

O Display LCD Azul 16x2 é um componente de visualização que consiste em uma tela de cristal líquido capaz de exibir caracteres alfanuméricos em duas linhas, cada uma com capacidade para exibir até 16 caracteres. Com sua cor azul característica, é comumente utilizado em projetos eletrônicos para fornecer feedback visual ao usuário.

No contexto do projeto do medidor de temperatura corporal, o Display LCD Azul 16x2 desempenhará um papel fundamental na exibição da temperatura medida.

5. **Módulo Wifi ESP8266**:

<img src="https://http2.mlstatic.com/D_NQ_NP_981074-MLB71758092352_092023-O.webp" alt="" width="200" style="margin-left: 20px"/>


O Módulo Wifi ESP8266 NodeMCU V3 é uma placa de desenvolvimento de microcontrolador de baixo custo e fácil utilização, ideal para projetos de Internet das Coisas (IoT). Ele é baseado no chip ESP8266, que possui recursos Wi-Fi integrados, permitindo que você conecte seus dispositivos à internet sem a necessidade de hardware adicional.

No contexto do projeto do medidor de temperatura corporal, o módulo wifi será utilizado para realizar a comunicação via MQTT.

## Interfaces protocolos e módulos de comunicação


O projeto do medidor de temperatura corporal utilizando a plataforma NodeMCU envolve diversas interfaces, protocolos e módulos de comunicação para funcionar de forma integrada e eficiente. Vamos detalhar cada um deles:

### Interfaces:

* **Serial**: A interface serial é utilizada para comunicação entre o computador e o módulo NodeMCU durante a programação e depuração do código. A taxa de baud padrão é de 9600 bps.

* **LCD**: A interface LCD é utilizada para comunicação entre o módulo NodeMCU e o display LCD 16x2. A biblioteca LiquidCrystal é utilizada para controlar o display e exibir as informações de temperatura.

### Protocolos:
* **MQTT**: O protocolo MQTT (Message Queuing Telemetry Transport) é um protocolo de comunicação leve e eficiente utilizado para a comunicação entre o módulo NodeMCU e o broker MQTT. O protocolo MQTT utiliza um modelo de publicação/assinatura, onde o módulo NodeMCU publica os dados de temperatura em um tópico específico e o servidor MQTT os recebe e armazena.

* **HTTP**: O protocolo HTTP (Hypertext Transfer Protocol) pode ser utilizado para configurar o Broker MQTT e visualizar os dados na nuvem.

### Módulos de Comunicação:

* **Módulo WiFi ESP8266**: O módulo WiFi ESP8266 é responsável pela conexão do NodeMCU à rede Wi-Fi. O módulo utiliza a biblioteca WiFi para se conectar à rede e estabelecer a comunicação com o broker MQTT.

* **Servidor MQTT**: O broker MQTT é responsável por receber os dados de temperatura publicados pelo módulo NodeMCU, armazená-los e disponibilizá-los para visualização em um dashboard. Diversos servidores MQTT gratuitos e pagos estão disponíveis online.
