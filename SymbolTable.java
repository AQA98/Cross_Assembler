import java.util.HashMap;

public class SymbolTable {
	// All the Hash Maps of the Mnemonic.

		public static HashMap<String, String> immediateMnemonic = new HashMap<String, String>();
		public static HashMap<String, String> relativeMnemonic = new HashMap<String, String>();
		public static HashMap<String, String>  inherentMnemonic = new HashMap<String, String>();
		public static HashMap<String, String>  binary = new HashMap<String, String>();
		
		public static final String immediateMnemonics[] = { "halt", "pop", "dup", "exit", "ret", "rfu1", "rfu2", "rfu3",
				"rfu4", "rfu5", "rfu6", "rfu7", "not", "and", "or", "xor", "neg", "inc", "dec", "add", "sub", "mul", "div",
				"rem", "shl", "shr", "teq", "tne", "tlt", "tgt", "tle", "tge" };

		
		
		
		public static String immediateToHex(String key) {

			// Immediate Mnemonics
			if (immediateMnemonic.isEmpty()) {

				immediateMnemonic.put("br.i5", "30");
				immediateMnemonic.put("brf.i5", "50");
				immediateMnemonic.put("enter.u5", "70");
				immediateMnemonic.put("ldc.i3", "90");
				immediateMnemonic.put("addv.u3", "98");
				immediateMnemonic.put("ldv.u3", "A0");
				immediateMnemonic.put("stv.u3", "A8");
				
				immediateMnemonic.put("addv.u8", "B0");
				immediateMnemonic.put("ldv.u8", "B1");
				immediateMnemonic.put("stv.u8", "B2");
				immediateMnemonic.put("incv", "B3");
				immediateMnemonic.put("decv", "B4");
				immediateMnemonic.put("enter.u8", "BF");
				immediateMnemonic.put("lda.i16", "D5");
				immediateMnemonic.put("ldc.i8", "D9");
				immediateMnemonic.put("ldc.i16", "DA");
				immediateMnemonic.put("lcd.i32", "DB");
				immediateMnemonic.put("br.i8", "E0");
				immediateMnemonic.put("br.i16", "E1");
				immediateMnemonic.put("brf.i8", "E3");
				immediateMnemonic.put("calls.i8", "E6");
				immediateMnemonic.put("calls.i16", "E7");
				immediateMnemonic.put("br", immediateMnemonic.get("br.i16"));
				immediateMnemonic.put("brf", immediateMnemonic.get("brf.i8"));
				immediateMnemonic.put("trap", "FF");
				
				immediateMnemonic.put("halt", "00");
				immediateMnemonic.put("pop", "01");
				immediateMnemonic.put("dup", "02");
				immediateMnemonic.put("exit", "03");
				immediateMnemonic.put("ret", "04");
				immediateMnemonic.put("RFU1", "05");
				immediateMnemonic.put("RFU2", "06");
				immediateMnemonic.put("RFU3", "07");
				immediateMnemonic.put("RFU4", "08");
				immediateMnemonic.put("RFU5", "09");
				immediateMnemonic.put("RFU6", "0A");
				immediateMnemonic.put("RFU7", "0B");
				immediateMnemonic.put("not", "0C");
				immediateMnemonic.put("and", "0D");
				immediateMnemonic.put("or", "0E");
				immediateMnemonic.put("xor", "0F");
				immediateMnemonic.put("neg", "10");
				immediateMnemonic.put("inc", "11");
				immediateMnemonic.put("dec", "12");
				immediateMnemonic.put("add", "13");
				immediateMnemonic.put("sub", "14");
				immediateMnemonic.put("mul", "15");
				immediateMnemonic.put("div", "16");
				immediateMnemonic.put("rem", "17");
				immediateMnemonic.put("shl", "18");
				immediateMnemonic.put("shr", "19");
				immediateMnemonic.put("teq", "1A");
				immediateMnemonic.put("tne", "1B");
				immediateMnemonic.put("tlt", "1C");
				immediateMnemonic.put("tgt", "1D");
				immediateMnemonic.put("tle", "1E");
				immediateMnemonic.put("tge", "1F");
				
		
			}
			return immediateMnemonic.get(key);
		}

		// Relative to Mnemonic

		public static String relativeToHex(String key) {

			if (relativeMnemonic.isEmpty()) {

				relativeMnemonic.put("addv.u8", "B0");
				relativeMnemonic.put("ldv.u8", "B1");
				relativeMnemonic.put("stv.u8", "B2");
				relativeMnemonic.put("incv", "B3");
				relativeMnemonic.put("decv", "B4");
				relativeMnemonic.put("enter.u8", "BF");
				relativeMnemonic.put("lda.i16", "D5");
				relativeMnemonic.put("ldc.i8", "D9");
				relativeMnemonic.put("ldc.i16", "DA");
				relativeMnemonic.put("lcd.i32", "DB");
				relativeMnemonic.put("br.i8", "E0");
				relativeMnemonic.put("br.i16", "E1");
				relativeMnemonic.put("brf.i8", "E3");
				relativeMnemonic.put("calls.i8", "E6");
				relativeMnemonic.put("calls.i16", "E7");
				relativeMnemonic.put("br", relativeMnemonic.get("br.i16"));
				relativeMnemonic.put("brf", relativeMnemonic.get("brf.i8"));
				relativeMnemonic.put("trap", "FF");
				
			}

			return relativeMnemonic.get(key);

		}

		public static String inherentToHex(String key) {

			if (inherentMnemonic.isEmpty()) {

				inherentMnemonic.put("halt", "00");
				inherentMnemonic.put("pop", "01");
				inherentMnemonic.put("dup", "02");
				inherentMnemonic.put("exit", "03");
				inherentMnemonic.put("ret", "04");
				inherentMnemonic.put("RFU1", "05");
				inherentMnemonic.put("RFU2", "06");
				inherentMnemonic.put("RFU3", "07");
				inherentMnemonic.put("RFU4", "08");
				inherentMnemonic.put("RFU5", "09");
				inherentMnemonic.put("RFU6", "0A");
				inherentMnemonic.put("RFU7", "0B");
				inherentMnemonic.put("not", "0C");
				inherentMnemonic.put("and", "0D");
				inherentMnemonic.put("or", "0E");
				inherentMnemonic.put("xor", "0F");
				inherentMnemonic.put("neg", "10");
				inherentMnemonic.put("inc", "11");
				inherentMnemonic.put("dec", "12");
				inherentMnemonic.put("add", "13");
				inherentMnemonic.put("sub", "14");
				inherentMnemonic.put("mul", "15");
				inherentMnemonic.put("div", "16");
				inherentMnemonic.put("rem", "17");
				inherentMnemonic.put("shl", "18");
				inherentMnemonic.put("shr", "19");
				inherentMnemonic.put("teq", "1A");
				inherentMnemonic.put("tne", "1B");
				inherentMnemonic.put("tlt", "1C");
				inherentMnemonic.put("tgt", "1D");
				inherentMnemonic.put("tle", "1E");
				inherentMnemonic.put("tge", "1F");

			}

			return immediateMnemonic.get(key);

		}
		public static String binary(String key) {

			if (binary.isEmpty()) {

				binary.put("halt", "000 00000");
				binary.put("pop", "000 00001");
				binary.put("dup", "000 00010");
				binary.put("exit", "000 00011");
				binary.put("ret", "000 00100");
				binary.put("RFU1", "000 00101");
				binary.put("RFU2", "000 00110");
				binary.put("RFU3", "000 00111");
				binary.put("RFU4", "000 01000");
				binary.put("RFU5", "000 01001");
				binary.put("RFU6", "000 01010");
				binary.put("RFU7", "000 01011");
				binary.put("not", "000 01100");
				binary.put("and", "000 01101");
				binary.put("or", "000 01110");
				binary.put("xor", "000 01111");
				binary.put("neg", "000 10000");
				binary.put("inc", "000 10001");
				binary.put("dec", "000 10010");
				binary.put("add", "000 10011");
				binary.put("sub", "000 10100");
				binary.put("mul", "000 10101");
				binary.put("div", "000 10110");
				binary.put("rem", "000 10111");
				binary.put("shl", "000 11000");
				binary.put("shr", "000 11001");
				binary.put("teq", "000 11010");
				binary.put("tne", "000 11011");
				binary.put("tlt", "000 11100");
				binary.put("tgt", "000 11101");
				binary.put("tle", "000 11110");
				binary.put("tge", "000 11111");

			}

			return binary.get(key);

		}

}
