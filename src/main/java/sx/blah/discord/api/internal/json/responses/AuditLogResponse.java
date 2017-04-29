package sx.blah.discord.api.internal.json.responses;

import sx.blah.discord.api.internal.json.objects.UserObject;

public class AuditLogResponse {
	public UserObject[] users;
	public Entry[] audit_log_entries;

	public static class Entry {
		public String target_id;
		public String user_id;
		public String id;
		public int action_type;

		public Change[] changes;

		public static class Change {
			public Object new_value;
			public Object old_value;
			public String key;
		}
	}
}
