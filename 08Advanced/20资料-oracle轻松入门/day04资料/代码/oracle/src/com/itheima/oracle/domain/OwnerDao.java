package com.itheima.oracle.domain;

import java.sql.SQLException;

import com.itheima.oracle.utils.DaoUtil;

public class OwnerDao {
	
	/**
	 * 新增业主
	 * @param owners
	 */
	public static void add(Owners owners) {

		java.sql.Connection conn = null;
		java.sql.PreparedStatement stmt = null;

		try {
			conn = DaoUtil.getConnection();
			stmt = conn.prepareStatement("insert into T_OWNERS values(?,?,?,?,?,?,?)");
			stmt.setLong(1, owners.getId());
			stmt.setString(2, owners.getName());
			stmt.setLong(3, owners.getAddressid());
			stmt.setString(4, owners.getHousenumber());
			stmt.setString(5, owners.getWatermeter());
			stmt.setDate(6, new java.sql.Date(owners.getAdddate().getTime()));
			stmt.setLong(7, owners.getOwnertypeid());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DaoUtil.closeAll(null, stmt, conn);
		}
	}

	/**
	 * 更新业主信息
	 * @param owners
	 */
	public static void update(Owners owners) {

		java.sql.Connection conn = null;
		java.sql.PreparedStatement stmt = null;

		try {
			conn = DaoUtil.getConnection();
			stmt = conn.prepareStatement("update T_OWNERS set name=?,addressid=?,housenumber=?,"
					+ "watermeter=?,adddate=?, ownertypeid=? where id=?");

			stmt.setString(1, owners.getName());
			stmt.setLong(2, owners.getAddressid());
			stmt.setString(3, owners.getHousenumber());
			stmt.setString(4, owners.getWatermeter());
			stmt.setDate(5, new java.sql.Date(owners.getAdddate().getTime()));
			stmt.setLong(6, owners.getOwnertypeid());
			stmt.setLong(7, owners.getId());
			stmt.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DaoUtil.closeAll(null, stmt, conn);
		}
	}

	/**
	 * 删除业主信息
	 * @param id
	 */
	public static void delete(Long id) {

		java.sql.Connection conn = null;
		java.sql.PreparedStatement stmt = null;

		try {
			conn = DaoUtil.getConnection();
			stmt = conn.prepareStatement("delete from T_OWNERS where id=?");
			stmt.setLong(1, id);
			stmt.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DaoUtil.closeAll(null, stmt, conn);
		}
	}

}
