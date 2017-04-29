package sx.blah.discord.util.audit;

import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.util.audit.entry.AuditLogEntry;
import sx.blah.discord.util.cache.Cache;

public class AuditLog {

	private final IGuild guild;
	private final AuditLogEntry<?>[] entries;
	public final Cache<IUser> users;

	public AuditLog(IGuild guild, Cache<IUser> users, AuditLogEntry[] entries) {
		this.guild = guild;
		this.entries = entries;
		this.users = users;
	}

	public IGuild getGuild() {
		return this.guild;
	}

	public AuditLogEntry<?>[] getEntries() {
		return this.entries;
	}
}
