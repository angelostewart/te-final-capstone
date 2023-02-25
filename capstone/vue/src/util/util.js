


export function isTrainer(account) {
    const user = account ? account : this.$store.state.user;
    if (!user) return false;
    return user.authorities.findIndex((u) => u.name === "ROLE_ADMIN") > -1;
  }

  