#include <WiFi.h>

const char* ssid = "Waroeng MieSoeh";
const char* password = "mienyemek";
const int ledPin = 2;

void setup() {
  Serial.begin(115200);
  pinMode(ledPin, OUTPUT);

  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Connecting to WiFi...");
  }

  while (true) {
    Serial.println("Connected to WiFi");
    digitalWrite(ledPin, HIGH);
    Serial.print("Local IP: ");
    Serial.println(WiFi.localIP());
  }
}

void loop() {}