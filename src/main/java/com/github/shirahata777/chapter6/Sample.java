package com.github.shirahata777.chapter6;

//  java.sqlはインターフェースだけではなく、例外・SQL操作に共通するクラスも提供している
import java.sql.Connection;
import java.sql.DriverManager;
// SQLを利用する時に利用
// PreparedStatementはSQLをコンパイルしてから利用
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Sample {

    public static void main(String[] args) throws SQLException {

        String url = "jbdc:derby://localhost:1527/data/Sample";
        String sql = "slect * from URL";

        Connection con = null;

        try {
            con = DriverManager.getConnection(url);

            System.out.println("con");
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            // DBMSの同時接続に限りがある為、通信が終わるたびにclose()を用いて閉じなければいけない
            con.close();
        }

        String sql2 = "slect * from URL item where id = ?";
        // try-with-resourceを利用する場合
        try (Connection con2 = DriverManager.getConnection(url);) {
            PreparedStatement ps = con2.prepareStatement(sql2);
            for (String id : args) {
                // sqlの「?」二何番目に値をセットするか指定（0を指定すると実行時にエラー）
                ps.setInt(1, Integer.parseInt(id));
                // ResultSetも解放してあげる必要がある（DBとのコネクションは解除されない）
                try (ResultSet rs = ps.executeQuery()) {
                    // rs.nect()を利用しないと値を取得できない（カーソルが動いていない状態）
                    while (rs.next()) {
                        System.out.println(rs.getInt("url"));
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // データを更新・削除・追加する際はexecuteUpdateを利用する
        String sql3 = "insert into item values(?,?)";
        try (Connection con3 = DriverManager.getConnection(url);) {
            try (PreparedStatement ps = con3.prepareStatement(sql3);) {
                ps.setString(1, "test");
                ps.setString(2, "test2");
                ps.executeUpdate();

            } catch (Exception e) {
                // TODO: handle exception
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (Connection con3 = DriverManager.getConnection(url);) {
            try (PreparedStatement ps = con3.prepareStatement(sql3);) {
                // execute()は結果を保持するオブジェクトがresulteSetか判定する
                if (ps.execute() == false) {
                    System.out.println(ps.getUpdateCount());
                    return;
                }
                ResultSet rs = ps.getResultSet();
                // metaデータを取得
                ResultSetMetaData meta = rs.getMetaData();
                // SQLによる結果の件数を取得
                int colSize = meta.getColumnCount();
                while (rs.next()) {
                    for(int i = 1;i<=colSize;i++){
                        System.out.println(rs.getString(i));
                    }
                } 

            } catch (Exception e) {
                // TODO: handle exception
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 複数のSQ Lを実行するときはaddBatchを利用する
        try (Connection con3 = DriverManager.getConnection(url);) {
            try (PreparedStatement ps = con3.prepareStatement(sql3);) {
                String[] list = {"apple","banana"};
                int i = 10;
                for(String l : list){
                    ps.setInt(1, i);
                    ps.setString(1, l);
                    ps.addBatch();
                }
                int resulte[] = ps.executeBatch();

            } catch (Exception e) {
                // TODO: handle exception
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // ストアドプロジジャーを呼び出すときは「prepareCall」を利用する
        
    }

}
