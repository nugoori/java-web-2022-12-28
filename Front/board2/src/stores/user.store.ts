import { IUser } from "src/interfaces";
import { create } from "zustand";

interface IUserStore {
    user: IUser | null;
    setUser: (user: IUser) => void;
    resetUser: () => void;
}

const useStore = create<IUserStore>((set) => ({
    user: null,
    setUser: (user: IUser) => set((state) => ({ ...state, user })),
    resetUser: () => set((state) => ({...state, user: null})),
}));

export default useStore;