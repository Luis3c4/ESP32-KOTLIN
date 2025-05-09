# 📱 proyectoESP32

Aplicación Android creada con Kotlin y Jetpack Compose

## 🚀 Tecnologías utilizadas

- **Kotlin**
- **Jetpack Compose**
- **Material 3**
- **AndroidX Libraries**
- **Gradle con Plugins DSL**

## 📦 Requisitos
- Andriod **14.0 UpsideDownCake**
- SDK de Android **API 34 UpsideDownCake**
- Java 11
- Gradle 8.x

## 🛠️ Configuración del proyecto

Este proyecto utiliza la nueva sintaxis **Gradle Kotlin DSL** con el archivo `libs.versions.toml` para manejar dependencias centralizadas.

```kotlin
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}
