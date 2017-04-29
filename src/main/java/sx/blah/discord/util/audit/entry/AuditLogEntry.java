package sx.blah.discord.util.audit.entry;

import sx.blah.discord.handle.obj.IAuditable;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IIDLinkedObject;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.util.audit.AuditLog;
import sx.blah.discord.util.audit.AuditLogActions;

public class AuditLogEntry<T extends IAuditable> implements IIDLinkedObject {

	private final long id;
	private final AuditLogActions action;
	private final IUser user;

	final long targetID;
	protected AuditLog log;

	private final Change<?>[] changes;

	public AuditLogEntry(long id, AuditLogActions action, IUser user, long targetID, Change<?>[] changes) {
		this.id = id;
		this.action = action;
		this.user = user;
		this.targetID = targetID;
		this.changes = changes;
	}

	public void setLog(AuditLog log) {
		this.log = log;
	}

	@SuppressWarnings("unchecked")
	public T getTarget() {
		switch(action.getTargetType()) { // TODO: Fix possible NPE
			case GUILD:
				return (T) log.getGuild();
			case CHANNEL:
				return (T) log.getGuild().getChannelByID(targetID);
			case USER:
				return (T) log.users.get(targetID);
			case ROLE:
				return (T) log.getGuild().getRoleByID(targetID);
			case INVITE:
				return null; // TODO: definitely not
			case WEBHOOK:
				return (T) log.getGuild().getWebhookByID(targetID);
			case EMOJI:
				return (T) log.getGuild().getEmojiByID(targetID);
		}

		return null; // TODO: probably not
	}

	@Override
	public long getLongID() {
		return this.id;
	}

	public IUser getUser() {
		return this.user;
	}

	public AuditLogActions getAction() {
		return this.action;
	}

	// TODO: This doesn't work well
	public static class Change<T> {
		private final String key;
		private final T oldValue;
		private final T newValue;

		public Change(String key, T oldValue, T newValue) {
			this.key = key;
			this.oldValue = oldValue;
			this.newValue = newValue;
		}

		public T getNewValue() {
			return newValue;
		}

		public T getOldValue() {
			return oldValue;
		}

		public String getKey() {
			return key;
		}
	}
}
