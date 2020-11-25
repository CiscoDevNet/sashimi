package code.messy.net.radius.attribute;

import java.nio.ByteBuffer;

public class CallingStationID implements AttributeIF {
	String id;
	
	public CallingStationID(byte[] value) {
		this.id = new String(value);
	}

	public CallingStationID(String id) {
		this.id = id;
	}
	
	@Override
	public ByteBuffer getPayload() {
		int length = id.length() + 2;
		ByteBuffer bb = ByteBuffer.allocate(length);
		bb.put((byte)31);
		bb.put((byte)length);
		bb.put(id.getBytes());
		bb.flip();
		return bb;
	}

	@Override
	public String toString() {
		return "CallingStationID=" + id;
	}
}
