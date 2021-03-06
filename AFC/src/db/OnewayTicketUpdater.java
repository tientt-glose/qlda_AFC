package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import interactor.TicketUpdater;

public class OnewayTicketUpdater implements TicketUpdater {

	@Override
	public void updateCertificateEnter(String certificateId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "UPDATE oneway_ticket SET status=" + Config.PENDING + " WHERE id=\"" + certificateId + "\"";
		statement.executeUpdate(sql);
		connection.close();
	}

	@Override
	public void updateCertificateExit(String certificateId, double fee) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "UPDATE oneway_ticket SET status=" + Config.EXPIRED + " WHERE id=\"" + certificateId + "\"";
		statement.executeUpdate(sql);
		connection.close();
	}

}
