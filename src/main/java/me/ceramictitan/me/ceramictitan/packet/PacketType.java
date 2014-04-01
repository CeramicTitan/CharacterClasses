package me.ceramictitan.me.ceramictitan.packet;

import me.ceramictitan.packets.protocol.Protocol;

public enum PacketType {
    ENTITY_SPAWN(Protocol.PLAY, Sender.SERVER, 0x0E, 0x17),
    ENTITY_LIVING_SPAWN(Protocol.PLAY, Sender.SERVER, 0x0F, 0x18),
    ENTITY_DESTROY(Protocol.PLAY, Sender.SERVER, 0x13, 0x1D),
    ENTITY_TELEPORT(Protocol.PLAY, Sender.SERVER, 0x18, 0x22),
    ENTITY_ATTACH(Protocol.PLAY, Sender.SERVER, 0x1B, 0x27),
    ENTITY_METADATA(Protocol.PLAY, Sender.SERVER, 0x1C, 0x28),
    CHAT(Protocol.PLAY, Sender.SERVER, 0x02, 0x03);

    private Protocol protocol;
    private Sender sender;
    private int id;
    private int legacyId;

    PacketType(Protocol protocol, Sender sender, int id, int legacyId) {
        this.protocol = protocol;
        this.sender = sender;
        this.id = id;
        this.legacyId = legacyId;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public Sender getSender() {
        return sender;
    }

    public int getId() {
        return id;
    }

    public int getLegacyId() {
        return this.legacyId;
    }
}