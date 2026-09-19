# --- 1. CARGA DE LIBRERÍAS Y DATOS ---
if (!require("psych")) install.packages("psych", quiet = TRUE)
library(psych)

Edad <- c(20, 22, 30, 33, 35)
Ciudad <- c("Barranquilla", "Bogota", "Cali", "Medellin", "Valledupar")
Nombres <- c("Alina", "jose", "Yesith", "Maria", "Carlos")

datos <- data.frame(Nombres, Ciudad, Edad)

cat("=== DATOS REGISTRADOS ===\n")
print(datos)
cat("\n")

# --- 2. RESUMEN ESTADÍSTICO COMPLETO (PSYCH) ---
cat("=== ANÁLISIS DESCRIPTIVO (psych::describe) ===\n")
print(describe(datos$Edad))
cat("\n")

# --- 3. MÉTRICAS COMPLEMENTARIAS ---
tabla_frecuencias <- table(datos$Edad)
moda <- names(which.max(tabla_frecuencias))
varianza <- var(datos$Edad)

cat("=== MÉTRICAS ESPECÍFICAS ===\n")
cat("Moda:", moda, "\n")
cat("Varianza:", varianza, "\n")
