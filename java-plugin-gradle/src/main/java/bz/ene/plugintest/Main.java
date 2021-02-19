package bz.ene.plugintest;

import com.github.jasync.sql.db.QueryResult;
import org.bukkit.plugin.java.JavaPlugin;
import com.github.jasync.sql.db.Connection;
import com.github.jasync.sql.db.RowData;
import com.github.jasync.sql.db.mysql.MySQLConnectionBuilder;
import org.slf4j.LoggerFactory;
import java.util.concurrent.ExecutionException;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
    	LoggerFactory.getLogger(this.getClass()).info("Test");
		Connection connection = MySQLConnectionBuilder.createConnectionPool("jdbc:mysql://127.0.0.1:3306/charms?user=root&password=password");

	    try {
		    QueryResult result = connection.sendQuery("select * from users;").get();

		    for(RowData row: result.getRows()) {
			    getLogger().info(row.getString("uuid"));
		    }
	    } catch (Exception e) {
		    e.printStackTrace();
	    }
    }

    @Override
    public void onDisable() {

    }
}
