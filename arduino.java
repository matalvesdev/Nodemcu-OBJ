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