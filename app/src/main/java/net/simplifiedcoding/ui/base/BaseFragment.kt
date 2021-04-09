package net.simplifiedcoding.ui.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment(@LayoutRes layout: Int) : Fragment(layout)