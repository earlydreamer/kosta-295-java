package app.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.mvc.common.DBManager;
import app.mvc.dto.BoardDTO;
import app.mvc.dto.ReplyDTO;
import app.mvc.exception.DMLException;
import app.mvc.exception.SearchWrongException;

public class BoardDAOImpl implements BoardDAO {

	private static BoardDAO instance = new BoardDAOImpl();

	private boolean isDefaultProfile = false;
	private String url = null;
	private String userid = null;
	private String password = null;

	public static BoardDAO getInstance() {
		return instance;
	}

	private BoardDAOImpl() {
		this.isDefaultProfile = true;
	}

	private BoardDAOImpl(String url, String userid, String password) {
		// 생성자 주입을 통한 url 및 id/pw 적용
		this.isDefaultProfile = false;
		this.url = url;
		this.userid = userid;
		this.password = password;
	}

	private final String BOARD_NO = "board_no";
	private final String SUBJECT = "subject";
	private final String WRITER = "writer";
	private final String CONTENT = "content";
	private final String BOARD_DATE = "board_date";

	@Override
	public List<BoardDTO> boardSelectAll() throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BoardDTO> list = new ArrayList<>();
		String sql = "select * from board order by board_no desc";
		try {
			if (this.isDefaultProfile)
				con = DBManager.getConnection();
			else
				con = DBManager.getConnection(url, userid, password);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			// 여기부터 작성하세요.
			while (rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setBoardNo(rs.getInt(BOARD_NO));
				board.setSubject(rs.getString(SUBJECT));
				board.setWriter(rs.getString(WRITER));
				board.setContent(rs.getString(CONTENT));
				board.setBoardDate(rs.getString(BOARD_DATE));
				list.add(board);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("DB에 문제가 있어 다시 진행해주요^^");

		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BoardDTO> list = new ArrayList<>();
		String sql = "select * from board where ? like %?% order by board_no desc";
		try {
			if (this.isDefaultProfile)
				con = DBManager.getConnection();
			else
				con = DBManager.getConnection(url, userid, password);
			ps = con.prepareStatement(sql);
			ps.setString(1, SUBJECT); // 상수필드 SUBJECT 의 값이 테이블명으로 (첫번째 ?)
			ps.setString(2, keyWord); // 전달받은 keyWord가 wildcard 안의 조건값으로 (두번째 ?)
			rs = ps.executeQuery();
			// 여기부터 작성하세요.
			while (rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setBoardNo(rs.getInt(BOARD_NO));
				board.setSubject(rs.getString(SUBJECT));
				board.setWriter(rs.getString(WRITER));
				board.setContent(rs.getString(CONTENT));
				board.setBoardDate(rs.getString(BOARD_DATE));
				list.add(board);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("DB에 문제가 있어 다시 진행해주요^^");

		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from board where boardno = ? order by board_no desc";
		BoardDTO board = new BoardDTO();
		try {
			if (this.isDefaultProfile)
				con = DBManager.getConnection();
			else
				con = DBManager.getConnection(url, userid, password);
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			rs = ps.executeQuery();
			// 여기부터 작성하세요.
			rs.next();
			board.setBoardNo(rs.getInt(BOARD_NO));
			board.setSubject(rs.getString(SUBJECT));
			board.setWriter(rs.getString(WRITER));
			board.setContent(rs.getString(CONTENT));
			board.setBoardDate(rs.getString(BOARD_DATE));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("DB에 문제가 있어 다시 진행해주요^^");

		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return board;
	}

	@Override
	public int boardInsert(BoardDTO boardDTO) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into board (subject, writer, content, board_date) values ( ?, '?, ?, now())";
		BoardDTO board = boardDTO;
		try {
			if (this.isDefaultProfile)
				con = DBManager.getConnection();
			else
				con = DBManager.getConnection(url, userid, password);

			ps = con.prepareStatement(sql);
			ps.setString(1, board.getSubject());
			ps.setString(2, board.getWriter());
			ps.setString(3, board.getContent());
			rs = ps.executeQuery();
			// 여기부터 작성하세요.

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("DB에 문제가 있어 다시 진행해주요^^");

		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return 0; // 정상실행이 완료되었다면 return 0;
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update board set subject = ?, writer = ?, content = ? content = ? boardDate = now() where board_no = ? ";
		BoardDTO board = new BoardDTO();
		try {
			if (this.isDefaultProfile)
				con = DBManager.getConnection();
			else
				con = DBManager.getConnection(url, userid, password);

			ps = con.prepareStatement(sql);
			ps.setString(1, board.getSubject());
			ps.setString(2, board.getWriter());
			ps.setString(3, board.getContent());

			rs = ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("DB에 문제가 있어 다시 진행해주요^^");

		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return 0; // 정상처리되었다면 return 0;
	}

	@Override
	public int boardDelete(int boardNo) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "delete from board where board_no = ?";
		try {
			if (this.isDefaultProfile)
				con = DBManager.getConnection();
			else
				con = DBManager.getConnection(url, userid, password);
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			rs = ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("DB에 문제가 있어 다시 진행해주요^^");

		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return 0;
	}

	@Override
	public int replyInsert(ReplyDTO replyDTO) throws DMLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardDTO replySelectByParentNo(int boardNo) throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from reply where board_no = ?";
		List<ReplyDTO> replyList = new ArrayList<ReplyDTO>();
		BoardDTO board = new BoardDTO();
		try {
			if (this.isDefaultProfile)
				con = DBManager.getConnection();
			else
				con = DBManager.getConnection(url, userid, password);

			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			rs = ps.executeQuery();			
					
			while(rs.next()) {
				ReplyDTO reply = new ReplyDTO();
				
				reply.setReplyNo(rs.getInt("reply_no"));
				reply.setReplyNo(rs.getInt("reply_content"));
				reply.setReplyNo(rs.getInt("board_no"));
				reply.setReplyNo(rs.getInt("reply_regdate"));
				
				replyList.add(reply);
				
			}
			board.setRepliesList(replyList); //다른정보를 사용하지않으므로 boad에 대한 초기화는 하지않고 그냥 빈객체에 replyList만 실어보낸다... 좋은구조는 아닌거 아는데 설계 안무너뜨리고 가자
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("DB에 문제가 있어 다시 진행해주요^^");

		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return board; // 정상실행이 완료되었다면 return board;
	}

	/***
	 * 부모글에 해당하는 댓글정보 가져오기
	 */
	private List<ReplyDTO> replySelect(Connection con, int boardNo) throws SQLException {
		
		return null;
	}

}
