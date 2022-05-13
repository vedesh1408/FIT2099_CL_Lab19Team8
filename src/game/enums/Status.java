package game.enums;

/**
 * Use this enum class to give `buff` or `debuff`.
 * It is also useful to give a `state` to abilities or actions that can be attached-detached.
 */
public enum Status {
    HOSTILE_TO_ENEMY, // use this status to be considered hostile towards enemy (e.g., to be attacked by enemy)
    TALL, // use this status to tell that current instance has "grown".
    DORMANT, // use this to indicate that koopa is dormant
    HOSTILE_TO_PLAYER, // use this status to be considered hostile towards player
    KILL_KOOPA, // use this to indicate what can kill a koopa
    DIRT, // used to indicate this ground is dirt and can be replaced (eg. to grow a new sprout)
    HAS_WRENCH, //use this to indicate if player has a wrench to kill a koopa
    INVINCIBILITY, //use this to indicate if player is invincible
    CAN_JUMP,
}
