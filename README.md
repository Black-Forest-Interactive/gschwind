# gschwind

A lightweight, Kotlin-based alternative to Apache Flink — focused on simplicity, composability, and staying true to the standard Stream API.

**Provided by [Black Forest Interactive](https://github.com/black-forest-interactive)**

---

## ✨ What is gschwind?

**gschwind** is a stream processing library designed to bring the power of real-time data transformation to Kotlin developers without the overhead of a heavyweight framework. Unlike Apache Flink, gschwind prioritizes being:

- 🪶 **Lightweight** – Avoid unnecessary complexity and dependencies
- 🧱 **Library-first** – Integrate easily into existing Kotlin applications
- 🔁 **Stream-like** – Familiar API modeled closely after Java/Kotlin streams
- 🚀 **Efficient** – Designed with performance and minimal resource usage in mind

Ideal for applications that require custom, embedded stream processing without needing full-blown distributed orchestration.

---

## 🛠 Features

- Fluent, composable stream operations
- Real-time or batch stream handling
- Functional API aligned with Kotlin idioms
- Zero-configuration usage
- Easily embeddable in any Kotlin/JVM project

---

## 📦 Installation

Coming soon via Maven Central. For now, include it as a local module or build from source.

### Gradle (local project)

```kotlin
dependencies {
    implementation(project(":gschwind"))
}
```

---

## 🚀 Getting Started

Here's a minimal example of using `gschwind`:

```kotlin
fun main() {
    val source = SampleSource() // create your source
    val stream = source.stream()
        .filter { it % 2 == 0 } // filter all values that are not even
        .map { it.toHexString() } // map it to a hex string
        .log("Even Values") // log the result
        .build()
    stream.print() // print the current structure of the string
    stream.start() // start the execution of the string
}
```

More examples coming soon!

---

## 📚 Documentation

Check the `demo/` directory in the repository for practical use cases.

Full API documentation is planned.

---

## 🧪 Running Tests

To execute the test suite:

```bash
./gradlew test
```

---

## 💡 Why "gschwind"?

“Gschwind” is a southern German word meaning **"fast"** or **"quick"**, reflecting the project's goal: a **fast, no-nonsense solution** for stream processing.

---

## 🧭 Roadmap

- [ ] Backpressure support
- [ ] Windowing capabilities
- [ ] Integration with Kafka, sockets, and other data sources
- [ ] Performance benchmarks
- [ ] Plugin architecture

---

## 🤝 Contributing

Contributions are very welcome!

- Open an issue
- Submit a pull request
- Or start a discussion to suggest a new idea

---

## 📄 License

This project is licensed under the **Apache License 2.0**.  
See the [LICENSE](./LICENSE) file for details.

---

## 📬 Contact

Made with ♥ by **[Black Forest Interactive](https://github.com/black-forest-interactive)**  
Questions or suggestions? Reach out via [GitHub Issues](https://github.com/black-forest-interactive/gschwind/issues)
