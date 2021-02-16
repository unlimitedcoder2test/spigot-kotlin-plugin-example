package dev.ahowe.example;

import com.github.jasync.sql.db.mysql.MySQLConnectionBuilder
import org.bukkit.plugin.java.JavaPlugin;

class ExamplePlugin: JavaPlugin() {
	val conn = MySQLConnectionBuilder.createConnectionPool("jdbc:mysql://127.0.0.1:3306/example?user=root&password=password");

	override fun onEnable() {
		logger.info("Enabled");
	}

	override fun onDisable() {
	}
}