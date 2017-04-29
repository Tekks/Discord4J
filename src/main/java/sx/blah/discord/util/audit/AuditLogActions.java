package sx.blah.discord.util.audit;

import java.util.Arrays;

public enum AuditLogActions {
	GUILD_UPDATE(1),

	CHANNEL_CREATE(10),
	CHANNEL_UPDATE(11),
	CHANNEL_DELETE(12),
	CHANNEL_OVERWRITE_CREATE(13),
	CHANNEL_OVERWRITE_UPDATE(14),
	CHANNEL_OVERWRITE_DELETE(15),

	MEMBER_KICK(20),
	MEMBER_PRUNE(21),
	MEMBER_BAN_ADD(22),
	MEMBER_BAN_REMOVE(23),
	MEMBER_UPDATE(24),
	MEMBER_ROLE_UPDATE(25),

	ROLE_CREATE(30),
	ROLE_UPDATE(31),
	ROLE_DELETE(32),

	INVITE_CREATE(40),
	INVITE_UPDATE(41),
	INVITE_DELETE(42),

	WEBHOOK_CREATE(50),
	WEBHOOK_UPDATE(51),
	WEBHOOK_DELETE(52),

	EMOJI_CREATE(60),
	EMOJI_UPDATE(61),
	EMOJI_DELETE(62),

	UNKNOWN(-1);

	private final int i; // TODO: rename

	AuditLogActions(int i) {
		this.i = i;
	}

	public int getI() {
		return this.i;
	}

	public static AuditLogActions get(int i) {
		return Arrays.stream(values()).filter(a -> a.i == i).findFirst().orElse(UNKNOWN);
	}

	public AuditLogTargets getTargetType() {
		switch (this) {
			case GUILD_UPDATE:
				return AuditLogTargets.GUILD;

			case CHANNEL_CREATE:
			case CHANNEL_UPDATE:
			case CHANNEL_DELETE:
			case CHANNEL_OVERWRITE_CREATE:
			case CHANNEL_OVERWRITE_UPDATE:
			case CHANNEL_OVERWRITE_DELETE:
				return AuditLogTargets.CHANNEL;

			case MEMBER_KICK:
			case MEMBER_PRUNE:
			case MEMBER_BAN_ADD:
			case MEMBER_BAN_REMOVE:
			case MEMBER_UPDATE:
			case MEMBER_ROLE_UPDATE:
				return AuditLogTargets.USER;

			case ROLE_CREATE:
			case ROLE_UPDATE:
			case ROLE_DELETE:
				return AuditLogTargets.ROLE;

			case INVITE_CREATE:
			case INVITE_UPDATE:
			case INVITE_DELETE:
				return AuditLogTargets.INVITE;

			case WEBHOOK_CREATE:
			case WEBHOOK_UPDATE:
			case WEBHOOK_DELETE:
				return AuditLogTargets.WEBHOOK;

			case EMOJI_CREATE:
			case EMOJI_UPDATE:
			case EMOJI_DELETE:
				return AuditLogTargets.EMOJI;
		}

		return null; // TODO: probably not
	}

	/*
	public Type getType() {
		switch (this) {
			case CHANNEL_CREATE:
			case CHANNEL_OVERWRITE_CREATE:
			case MEMBER_BAN_REMOVE:
			case ROLE_CREATE:
			case INVITE_CREATE:
			case WEBHOOK_CREATE:
			case EMOJI_CREATE:
				return Type.CREATE;

			case CHANNEL_DELETE:
			case CHANNEL_OVERWRITE_DELETE:
			case MEMBER_KICK:
			case MEMBER_PRUNE:
			case MEMBER_BAN_ADD:
			case ROLE_DELETE:
			case INVITE_DELETE:
			case WEBHOOK_DELETE:
			case EMOJI_DELETE:
				return Type.DELETE;

			case GUILD_UPDATE:
			case CHANNEL_UPDATE:
			case CHANNEL_OVERWRITE_UPDATE:
			case MEMBER_UPDATE:
			case ROLE_UPDATE:
			case INVITE_UPDATE:
			case WEBHOOK_UPDATE:
			case EMOJI_UPDATE:
				return Type.UPDATE;
		}

		return Type.ALL;
	}

	public enum Type {
		CREATE,
		DELETE,
		UPDATE,
		ALL
	}
	*/
}
