interface AnInterface {
    default abstract void invalidMethod(); // Cannot be both abstract and default!
}