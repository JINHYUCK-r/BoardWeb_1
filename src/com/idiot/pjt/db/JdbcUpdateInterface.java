package com.idiot.pjt.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface JdbcUpdateInterface {
	void update(PreparedStatement ps) throws SQLException;
}
