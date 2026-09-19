# DATOS
Edad <- c(20, 22, 30, 33, 35)
Ciudad <- c("Barranquilla", "Bogota", "Cali", "Medellin", "Valledupar")
Nombres <- c("Alina", "jose", "Yesith", "Maria", "Carlos")


# unir datos
datos <- data.frame(Nombres, Ciudad, Edad); datos

# medidas estadísticas
"Medidas de tendencia central"
summary(datos) # resumen estadístico de los datos

media <- mean(datos$Edad); media
mediana <- median(datos$Edad)

# Moda parte 1: Crea la tabla de frecuencias
Moda <- table(datos$Edad); Moda

# Moda parte 2: Extrae el valor que más se repite
moda_2 <- names(which.max(Moda))

varianza <- var(datos$Edad); varianza
desviacion <- sd(datos$Edad); desviacion
DESV <- sqrt(varianza); DESV

# paquere
library(psych)
describe(datos$Edad)
